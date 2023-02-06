import { Component, OnInit } from '@angular/core';
import { JobService } from '../services/job.service';
import { StateService } from '../services/state.service';

@Component({
  selector: 'app-detailed-service',
  templateUrl: './detailed-service.component.html',
  styleUrls: ['./detailed-service.component.scss']
})
export class DetailedServiceComponent implements OnInit {

  id: any
  service: any
  imgSrc!: any
  userLoggedIn: any

  constructor(private state: StateService, private jobService: JobService) { }

  ngOnInit(): void {
    this.id = this.state.data,

    this.state.data = undefined,
    this.jobService.getJobDetails(this.id).subscribe(
      (data:any) => {this.service = data, this.imgSrc = data.title},
      err => console.log(err)
    )
    this.jobService.getUserLoggedInDetails().subscribe(
      data => this.userLoggedIn = data,
      err => console.log(err)
    )

    console.log(this.userLoggedIn)
  }

}
