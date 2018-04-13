webpackJsonp(["main"],{

/***/ "./src/$$_lazy_route_resource lazy recursive":
/***/ (function(module, exports) {

function webpackEmptyAsyncContext(req) {
	// Here Promise.resolve().then() is used instead of new Promise() to prevent
	// uncatched exception popping up in devtools
	return Promise.resolve().then(function() {
		throw new Error("Cannot find module '" + req + "'.");
	});
}
webpackEmptyAsyncContext.keys = function() { return []; };
webpackEmptyAsyncContext.resolve = webpackEmptyAsyncContext;
module.exports = webpackEmptyAsyncContext;
webpackEmptyAsyncContext.id = "./src/$$_lazy_route_resource lazy recursive";

/***/ }),

/***/ "./src/app/app.component.css":
/***/ (function(module, exports) {

module.exports = ""

/***/ }),

/***/ "./src/app/app.component.html":
/***/ (function(module, exports) {

module.exports = "<!--The content below is only a placeholder and can be replaced.-->\n<mat-toolbar color=\"primary\">\n  <span>Welcome to {{title}}!</span>\n</mat-toolbar>\n<router-outlet></router-outlet>\n\n\n"

/***/ }),

/***/ "./src/app/app.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return AppComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("./node_modules/@angular/core/esm5/core.js");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};

var AppComponent = /** @class */ (function () {
    function AppComponent() {
        this.title = 'Petclinic';
    }
    AppComponent = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["n" /* Component */])({
            selector: 'app-root',
            template: __webpack_require__("./src/app/app.component.html"),
            styles: [__webpack_require__("./src/app/app.component.css")]
        })
    ], AppComponent);
    return AppComponent;
}());



/***/ }),

/***/ "./src/app/app.module.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return AppModule; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_platform_browser__ = __webpack_require__("./node_modules/@angular/platform-browser/esm5/platform-browser.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_core__ = __webpack_require__("./node_modules/@angular/core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__app_component__ = __webpack_require__("./src/app/app.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__shared_pet_pet_service__ = __webpack_require__("./src/app/shared/pet/pet.service.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__angular_common_http__ = __webpack_require__("./node_modules/@angular/common/esm5/http.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5__pet_list_pet_list_component__ = __webpack_require__("./src/app/pet-list/pet-list.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_6__angular_material__ = __webpack_require__("./node_modules/@angular/material/esm5/material.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_7__angular_platform_browser_animations__ = __webpack_require__("./node_modules/@angular/platform-browser/esm5/animations.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_8__pet_edit_pet_edit_component__ = __webpack_require__("./src/app/pet-edit/pet-edit.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_9__angular_forms__ = __webpack_require__("./node_modules/@angular/forms/esm5/forms.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_10__angular_router__ = __webpack_require__("./node_modules/@angular/router/esm5/router.js");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};











// Define routes
var appRoutes = [
    { path: '', redirectTo: '/pet-list', pathMatch: 'full' },
    {
        path: 'pet-list',
        component: __WEBPACK_IMPORTED_MODULE_5__pet_list_pet_list_component__["a" /* PetListComponent */]
    },
    {
        path: 'pet-add',
        component: __WEBPACK_IMPORTED_MODULE_8__pet_edit_pet_edit_component__["a" /* PetEditComponent */]
    },
    {
        path: 'pet-edit/:id',
        component: __WEBPACK_IMPORTED_MODULE_8__pet_edit_pet_edit_component__["a" /* PetEditComponent */]
    }
];
// Include all the modules, declarations, etc.
var AppModule = /** @class */ (function () {
    function AppModule() {
    }
    AppModule = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_1__angular_core__["K" /* NgModule */])({
            declarations: [
                __WEBPACK_IMPORTED_MODULE_2__app_component__["a" /* AppComponent */],
                __WEBPACK_IMPORTED_MODULE_5__pet_list_pet_list_component__["a" /* PetListComponent */],
                __WEBPACK_IMPORTED_MODULE_8__pet_edit_pet_edit_component__["a" /* PetEditComponent */]
            ],
            imports: [
                __WEBPACK_IMPORTED_MODULE_0__angular_platform_browser__["a" /* BrowserModule */],
                __WEBPACK_IMPORTED_MODULE_4__angular_common_http__["b" /* HttpClientModule */],
                __WEBPACK_IMPORTED_MODULE_7__angular_platform_browser_animations__["a" /* BrowserAnimationsModule */],
                __WEBPACK_IMPORTED_MODULE_6__angular_material__["a" /* MatButtonModule */],
                __WEBPACK_IMPORTED_MODULE_6__angular_material__["b" /* MatCardModule */],
                __WEBPACK_IMPORTED_MODULE_6__angular_material__["c" /* MatInputModule */],
                __WEBPACK_IMPORTED_MODULE_6__angular_material__["e" /* MatSelectModule */],
                __WEBPACK_IMPORTED_MODULE_6__angular_material__["d" /* MatListModule */],
                __WEBPACK_IMPORTED_MODULE_6__angular_material__["f" /* MatToolbarModule */],
                __WEBPACK_IMPORTED_MODULE_9__angular_forms__["c" /* FormsModule */],
                __WEBPACK_IMPORTED_MODULE_10__angular_router__["c" /* RouterModule */].forRoot(appRoutes)
            ],
            providers: [__WEBPACK_IMPORTED_MODULE_3__shared_pet_pet_service__["a" /* PetService */]],
            bootstrap: [__WEBPACK_IMPORTED_MODULE_2__app_component__["a" /* AppComponent */]]
        })
    ], AppModule);
    return AppModule;
}());



/***/ }),

/***/ "./src/app/pet-edit/pet-edit.component.css":
/***/ (function(module, exports) {

module.exports = ""

/***/ }),

/***/ "./src/app/pet-edit/pet-edit.component.html":
/***/ (function(module, exports) {

module.exports = "<mat-card>\n    <form #petForm=\"ngForm\" (ngSubmit)=\"save(petForm.value)\">\n        <mat-card-header>\n            <mat-card-title><h2>{{pet.name ? 'Edit' : 'Add'}} Pet</h2></mat-card-title>\n        </mat-card-header>\n        <mat-card-content>\n            <input type=\"hidden\" name=\"id\" [(ngModel)]=\"pet.id\" #id>\n            <input type=\"hidden\" name=\"version\" [(ngModel)]=\"pet.version\" #version>\n            <!-- Indicate the pet name -->\n            <mat-form-field>\n                <input matInput placeholder=\"Name\" [(ngModel)]=\"pet.name\"\n                       required name=\"name\" #name>\n            </mat-form-field>\n            <!-- Indicate the pet weight -->\n            <mat-form-field>\n                <input matInput type=\"number\" placeholder=\"Weight\" [(ngModel)]=\"pet.weight\"\n                       required name=\"weight\" #weight>\n            </mat-form-field>\n            <!-- Indicate the pet type -->\n            <mat-form-field>\n                <mat-select placeholder=\"Type\" required name=\"type\" [(ngModel)]=\"pet.type\" #type>\n                    <mat-option *ngFor=\"let petType of petTypes\" [value]=\"petType\">\n                        {{ petType }}\n                    </mat-option>\n                </mat-select>\n            </mat-form-field>\n        </mat-card-content>\n        <mat-card-actions>\n            <button mat-raised-button color=\"primary\" type=\"submit\"\n                    [disabled]=\"!petForm.form.valid\">Save\n            </button>\n            <button mat-raised-button color=\"secondary\" (click)=\"remove(pet.id)\"\n                    *ngIf=\"pet.id\" type=\"button\">Delete\n            </button>\n            <a mat-button routerLink=\"/pet-list\">Cancel</a>\n        </mat-card-actions>\n    </form>\n</mat-card>"

/***/ }),

/***/ "./src/app/pet-edit/pet-edit.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return PetEditComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("./node_modules/@angular/core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_router__ = __webpack_require__("./node_modules/@angular/router/esm5/router.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__shared_pet_pet_service__ = __webpack_require__("./src/app/shared/pet/pet.service.ts");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};



var PetEditComponent = /** @class */ (function () {
    function PetEditComponent(route, router, petService) {
        this.route = route;
        this.router = router;
        this.petService = petService;
        this.pet = {};
        this.petTypes = [];
    }
    PetEditComponent.prototype.ngOnInit = function () {
        var _this = this;
        this.sub = this.route.params.subscribe(function (params) {
            var id = params['id'];
            if (id) {
                _this.petService.get(id).subscribe(function (pet) {
                    if (pet) {
                        _this.pet = pet;
                    }
                    else {
                        console.log("Pet with id '" + id + "' not found, returning to list");
                        _this.gotoList();
                    }
                });
            }
        });
        // Fill the types select
        this.fillTypes();
    };
    PetEditComponent.prototype.ngOnDestroy = function () {
        this.sub.unsubscribe();
    };
    PetEditComponent.prototype.gotoList = function () {
        this.router.navigate(['/pet-list']);
    };
    PetEditComponent.prototype.save = function (form) {
        var _this = this;
        this.petService.save(form).subscribe(function (result) {
            _this.gotoList();
        }, function (error) { return console.error(error); });
    };
    PetEditComponent.prototype.remove = function (href) {
        var _this = this;
        this.petService.remove(href).subscribe(function (result) {
            _this.gotoList();
        }, function (error) { return console.error(error); });
    };
    PetEditComponent.prototype.fillTypes = function () {
        var _this = this;
        this.petService.getTypes().subscribe(function (result) {
            _this.petTypes = result;
        }, function (error) { return console.error(error); });
    };
    PetEditComponent = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["n" /* Component */])({
            selector: 'app-pet-edit',
            template: __webpack_require__("./src/app/pet-edit/pet-edit.component.html"),
            styles: [__webpack_require__("./src/app/pet-edit/pet-edit.component.css")]
        }),
        __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_1__angular_router__["a" /* ActivatedRoute */],
            __WEBPACK_IMPORTED_MODULE_1__angular_router__["b" /* Router */],
            __WEBPACK_IMPORTED_MODULE_2__shared_pet_pet_service__["a" /* PetService */]])
    ], PetEditComponent);
    return PetEditComponent;
}());



/***/ }),

/***/ "./src/app/pet-list/pet-list.component.css":
/***/ (function(module, exports) {

module.exports = ""

/***/ }),

/***/ "./src/app/pet-list/pet-list.component.html":
/***/ (function(module, exports) {

module.exports = "<mat-card>\n  <mat-card-header>Pet List</mat-card-header>\n  <mat-card-content>\n    <mat-list>\n      <mat-list-item *ngFor=\"let pet of pets\">\n        <h3 mat-line>\n          <a mat-button [routerLink]=\"['/pet-edit', pet.id]\">{{pet.name}}</a>\n        </h3>\n      </mat-list-item>\n    </mat-list>\n  </mat-card-content>\n\n  <button mat-fab color=\"primary\" [routerLink]=\"['/pet-add']\">Add</button>\n\n</mat-card>\n"

/***/ }),

/***/ "./src/app/pet-list/pet-list.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return PetListComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("./node_modules/@angular/core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__shared_pet_pet_service__ = __webpack_require__("./src/app/shared/pet/pet.service.ts");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};


var PetListComponent = /** @class */ (function () {
    function PetListComponent(petService) {
        this.petService = petService;
    }
    PetListComponent.prototype.ngOnInit = function () {
        var _this = this;
        this.petService.getAll().subscribe(function (data) {
            _this.pets = data;
        });
    };
    PetListComponent = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["n" /* Component */])({
            selector: 'app-pet-list',
            template: __webpack_require__("./src/app/pet-list/pet-list.component.html"),
            styles: [__webpack_require__("./src/app/pet-list/pet-list.component.css")]
        }),
        __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_1__shared_pet_pet_service__["a" /* PetService */]])
    ], PetListComponent);
    return PetListComponent;
}());



/***/ }),

/***/ "./src/app/shared/pet/pet.service.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return PetService; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("./node_modules/@angular/core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_common_http__ = __webpack_require__("./node_modules/@angular/common/esm5/http.js");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};


var PetService = /** @class */ (function () {
    /**
     * The default constructor
     *
     * @param {HttpClient} http
     */
    function PetService(http) {
        this.http = http;
        this.PETS_URL = '/api/pets';
    }
    /**
     * Method to obtain all the registered pets
     *
     * @returns {Observable<any>}
     */
    PetService.prototype.getAll = function () {
        return this.http.get(this.PETS_URL);
    };
    /**
     * Method to obtain an individual pet
     *
     * @param {string} id
     * @returns {Observable<Object>}
     */
    PetService.prototype.get = function (id) {
        return this.http.get(this.PETS_URL + '/' + id);
    };
    /**
     * Method to add a new pet
     *
     * @param pet
     * @returns {Observable<any>}
     */
    PetService.prototype.save = function (pet) {
        var result;
        if (pet.id != null && pet.version != null) {
            result = this.http.put(this.PETS_URL + '/' + pet.id, pet);
        }
        else {
            result = this.http.post(this.PETS_URL, pet);
        }
        return result;
    };
    /**
     * Method that removes the provided pet id
     *
     * @param {string} href
     * @returns {Observable<Object>}
     */
    PetService.prototype.remove = function (id) {
        return this.http.delete(this.PETS_URL + '/' + id);
    };
    /**
     * Obtains all the existing pet types
     *
     * @returns {Observable<Object>}
     */
    PetService.prototype.getTypes = function () {
        return this.http.get(this.PETS_URL + '/types');
    };
    PetService = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["C" /* Injectable */])(),
        __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_1__angular_common_http__["a" /* HttpClient */]])
    ], PetService);
    return PetService;
}());



/***/ }),

/***/ "./src/environments/environment.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return environment; });
// The file contents for the current environment will overwrite these during build.
// The build system defaults to the dev environment which uses `environment.ts`, but if you do
// `ng build --env=prod` then `environment.prod.ts` will be used instead.
// The list of which env maps to which file can be found in `.angular-cli.json`.
var environment = {
    production: false
};


/***/ }),

/***/ "./src/main.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
Object.defineProperty(__webpack_exports__, "__esModule", { value: true });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("./node_modules/@angular/core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_platform_browser_dynamic__ = __webpack_require__("./node_modules/@angular/platform-browser-dynamic/esm5/platform-browser-dynamic.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__app_app_module__ = __webpack_require__("./src/app/app.module.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__environments_environment__ = __webpack_require__("./src/environments/environment.ts");




if (__WEBPACK_IMPORTED_MODULE_3__environments_environment__["a" /* environment */].production) {
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["_17" /* enableProdMode */])();
}
Object(__WEBPACK_IMPORTED_MODULE_1__angular_platform_browser_dynamic__["a" /* platformBrowserDynamic */])().bootstrapModule(__WEBPACK_IMPORTED_MODULE_2__app_app_module__["a" /* AppModule */])
    .catch(function (err) { return console.log(err); });


/***/ }),

/***/ 0:
/***/ (function(module, exports, __webpack_require__) {

module.exports = __webpack_require__("./src/main.ts");


/***/ })

},[0]);
//# sourceMappingURL=main.bundle.js.map