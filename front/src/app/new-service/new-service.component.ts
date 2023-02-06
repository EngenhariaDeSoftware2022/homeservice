import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { IService, JobService } from '../services/job.service';

@Component({
  selector: 'app-new-service',
  templateUrl: './new-service.component.html',
  styleUrls: ['./new-service.component.scss']
})
export class NewServiceComponent implements OnInit {

  choosedImg: string = 'encanador'

  newServiceForm = new FormGroup({
    title: new FormControl('', Validators.required),
    tag: new FormControl('', Validators.required),
    description: new FormControl('', Validators.required),
    value: new FormControl('', Validators.required),
    city: new FormControl('', Validators.required),
    neighborhood: new FormControl('', Validators.required),
    cel: new FormControl('', Validators.required)
  })

  tags = []

  constructor(private jobService: JobService) { }

  ngOnInit(): void {
    this.jobService.getTags().subscribe(
      (data:any) => this.tags = data,
      (err) => console.log(err)
    )
  }

  save() {
    if(this.newServiceForm.valid) {
      let service = {
          cel: this.newServiceForm.get('cel')?.value,
          city: this.newServiceForm.get('city')?.value,
          description: this.newServiceForm.get('description')?.value,
          neighborhood: this.newServiceForm.get('neighborhood')?.value,
          tag: this.newServiceForm.get('tag')?.value,
          title: this.choosedImg,
          value: this.newServiceForm.get('value')?.value
      }

      this.jobService.createService(service).subscribe(
        data => {console.log(data), alert('Criado com sucesso!')},
        err => {console.log(err), alert('Erro ao criar serviço!')}
      )
    }
  }
  }
