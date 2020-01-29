import { Component, OnInit } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
// eslint-disable-next-line @typescript-eslint/no-unused-vars
import { FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import * as moment from 'moment';
import { DATE_TIME_FORMAT } from 'app/shared/constants/input.constants';

import { IClient, Client } from 'app/shared/model/client.model';
import { ClientService } from './client.service';

@Component({
  selector: 'jhi-client-update',
  templateUrl: './client-update.component.html'
})
export class ClientUpdateComponent implements OnInit {
  isSaving = false;

  editForm = this.fb.group({
    id: [],
    nombre: [null, [Validators.required]],
    apellido: [null, [Validators.required]],
    direccion: [],
    cedula: [null, [Validators.minLength(10), Validators.maxLength(10)]],
    telefono: [null, [Validators.minLength(10), Validators.maxLength(10)]],
    celular: [null, [Validators.minLength(10), Validators.maxLength(10)]],
    sexo: [null, [Validators.required]],
    email: [],
    fechaDeIngreso: [null, [Validators.required]]
  });

  constructor(protected clientService: ClientService, protected activatedRoute: ActivatedRoute, private fb: FormBuilder) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ client }) => {
      this.updateForm(client);
    });
  }

  updateForm(client: IClient): void {
    this.editForm.patchValue({
      id: client.id,
      nombre: client.nombre,
      apellido: client.apellido,
      direccion: client.direccion,
      cedula: client.cedula,
      telefono: client.telefono,
      celular: client.celular,
      sexo: client.sexo,
      email: client.email,
      fechaDeIngreso: client.fechaDeIngreso != null ? client.fechaDeIngreso.format(DATE_TIME_FORMAT) : null
    });
  }

  previousState(): void {
    window.history.back();
  }

  save(): void {
    this.isSaving = true;
    const client = this.createFromForm();
    if (client.id !== undefined) {
      this.subscribeToSaveResponse(this.clientService.update(client));
    } else {
      this.subscribeToSaveResponse(this.clientService.create(client));
    }
  }

  private createFromForm(): IClient {
    return {
      ...new Client(),
      id: this.editForm.get(['id'])!.value,
      nombre: this.editForm.get(['nombre'])!.value,
      apellido: this.editForm.get(['apellido'])!.value,
      direccion: this.editForm.get(['direccion'])!.value,
      cedula: this.editForm.get(['cedula'])!.value,
      telefono: this.editForm.get(['telefono'])!.value,
      celular: this.editForm.get(['celular'])!.value,
      sexo: this.editForm.get(['sexo'])!.value,
      email: this.editForm.get(['email'])!.value,
      fechaDeIngreso:
        this.editForm.get(['fechaDeIngreso'])!.value != null
          ? moment(this.editForm.get(['fechaDeIngreso'])!.value, DATE_TIME_FORMAT)
          : undefined
    };
  }

  protected subscribeToSaveResponse(result: Observable<HttpResponse<IClient>>): void {
    result.subscribe(
      () => this.onSaveSuccess(),
      () => this.onSaveError()
    );
  }

  protected onSaveSuccess(): void {
    this.isSaving = false;
    this.previousState();
  }

  protected onSaveError(): void {
    this.isSaving = false;
  }
}
