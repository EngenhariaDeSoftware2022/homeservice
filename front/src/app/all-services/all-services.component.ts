import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Route, Router } from '@angular/router';
import { IService, JobService } from '../services/job.service';
import { StateService } from '../services/state.service';


@Component({
  selector: 'app-all-services',
  templateUrl: './all-services.component.html',
  styleUrls: ['./all-services.component.scss']
})
export class AllServicesComponent implements OnInit {

  services: any[] = []
  servicesView: any[] = []

  searchText!: FormGroup

  constructor(private jobService: JobService, private router: Router, private state: StateService) {}

  ngOnInit(): void {
    this.jobService.getServices().subscribe(
      (data:any) => {
        for (let service of data) {
          this.services.push(service)
        }
      },
      (err) => {console.log(err)}
    )
    this.servicesView = this.services
    this.searchText = new FormGroup({
      searchText: new FormControl('')
    })
  }

  filter() {
    this.servicesView = this.services.filter(it => {
      return it.description.toLocaleLowerCase().includes(this.searchText.value.searchText);
    });
  }

  showServiceDetails(id: any) {
    console.log('all-service',id)
    this.state.data = id
    this.router.navigate(['/detailed-service'])
  }

}
