import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { IService, JobService } from '../services/job.service';

@Component({
  selector: 'app-my-services',
  templateUrl: './my-services.component.html',
  styleUrls: ['./my-services.component.scss']
})
export class MyServicesComponent implements OnInit {

  myServices: any[] = []

  constructor(private jobService: JobService, private router: Router) {
    this.router.routeReuseStrategy.shouldReuseRoute = () => {
      return false;
    };
  }

  ngOnInit(): void {
    this.jobService.getUserServices().subscribe(
      (data:any) => {
        for (let service of data.jobs) {
          this.myServices.push(service)
        }
      }
    )
  }

  delete(id: any) {
    this.jobService.deleteJob(id).subscribe(
      data => {
        alert('Deletado com sucesso!'),
        this.router.navigate(['/my-services'])
      },
      err => console.log(err)
    )
  }

}
