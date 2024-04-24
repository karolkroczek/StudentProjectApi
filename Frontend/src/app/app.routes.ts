import { Routes } from '@angular/router';

import { NotFoundPageComponent } from './pages/not-found-page/not-found-page.component';
import { LoginComponent } from './pages/login/login.component';
import { MainPageComponent } from './pages/main-page/main-page.component';
import { AuthGurad } from './authGuard';
import { LessonActivitiesFormComponent, activitiesList,          } from './pages/lesson-activities-form/lesson-activities-form.component';
import { MessagesComponent } from './pages/messages/messages.component';
import { NewMessageComponent } from './pages/new-message/new-message.component';
import { NewLessonComponent } from './pages/new-lesson/new-lesson.component';
import { StudentOverviewComponent } from './pages/student-overview/student-overview.component';
import { GradesPageComponent } from './pages/grades-page/grades-page.component';
import { GradeFormComponent } from './pages/grade-form/grade-form.component';
import { ScheduleComponent } from './pages/schedule/schedule.component';
import { ProfileComponent } from './pages/profile/profile.component';
import { ClassOverviewComponent } from './pages/class-overview/class-overview.component';
import { HomeworksComponent } from './pages/homeworks/homeworks.component';
import { NewTeacherComponent } from './pages/new-teacher/new-teacher.component';
import { NewStudentComponent } from './pages/new-student/new-student.component';
import { TeacherListComponent } from './pages/teacher-list/teacher-list.component';
import { MessageViewComponent } from './pages/message-view/message-view.component';
import { StudentListComponent } from './pages/student-list/student-list.component';
import { TestsListComponent } from './pages/tests-list/tests-list.component';
import { SubjectOverviewComponent } from './pages/subject-overview/subject-overview.component';
import { NewSubjectComponent } from './pages/new-subject/new-subject.component';
import { NewDayScheduleComponent } from './pages/new-day-schedule/new-day-schedule.component';
import { NewScheduleComponent } from './pages/new-schedule/new-schedule.component';
import { NewSchoolClassComponent } from './pages/new-school-class/new-school-class.component';
import { FirstRunPageComponent } from './pages/first-run-page/first-run-page.component';

export const routes: Routes = [
    {path: 'student-page', component:MainPageComponent},
    {path: 'teacher-page', component:MainPageComponent},
    {path: 'main', component:MainPageComponent},
    {path: 'login',component:LoginComponent},
    {path: 'lesson-activities-form/homework',component:LessonActivitiesFormComponent, data:{activityName:"HOMEWORK"}},
    {path: 'lesson-activities-form/:id/quiz',component:LessonActivitiesFormComponent, data:{activityName:"QUIZ"}},
    {path: 'messages',component:MessagesComponent},
    {path: 'new-message',component:NewMessageComponent},
    {path: 'view-message/:id',component:MessageViewComponent},
    {path: 'new-lesson',component:NewLessonComponent},
    {path: 'new-teacher',component:NewTeacherComponent},
    {path: 'new-student',component:NewStudentComponent},
    {path: 'all-teachers',component:TeacherListComponent},
    {path: 'all-students',component:StudentListComponent},
    {path: 'all-tests',component:TestsListComponent},
    {path: 'student-overview',component:StudentOverviewComponent},
    {path: 'grades-page/:id',component:GradesPageComponent},
    {path: 'new-grade/:id',component:GradeFormComponent},
    {path: 'new-day',component:NewDayScheduleComponent},
    {path: 'new-schedule',component:NewScheduleComponent},
    {path: 'first',component:FirstRunPageComponent},
    {path: 'new-school-class',component:NewSchoolClassComponent},
    {path: 'schedule',component:ScheduleComponent},
    {path: 'subject-overview',component:SubjectOverviewComponent},
    {path: 'new-subject',component:NewSubjectComponent},
    {path: 'profile',component:ProfileComponent,data:{userId:"userId"}},
    {path: 'class-overview',component:ClassOverviewComponent},
    {path: 'class-overview/:id',component:StudentOverviewComponent,data:{listType:"GRADES"}},
    {path: 'class-overview/:id/note',component:StudentOverviewComponent,data:{listType:"NOTE"}},
    {path: 'class-overview/:id/grades',component:StudentOverviewComponent,data:{listType:"GRADES"}},
    {path: 'class-overview/:id/frequency',component:StudentOverviewComponent,data:{listType:"FREQUENCY"}},
    {path: 'homeworks',component:HomeworksComponent},
    {path: '',redirectTo:'login',pathMatch:'full'},  
    {path:'**',component:NotFoundPageComponent} 
];
