angular.module('myapp.constant', [])

.constant('RESOURCE_DOMAIN','http://whatshapp.local:8080/WhatsHappBackend/rest/')
.constant(
		'RESOURCE_CONFIG', {
			headers : {
				'Content-Type' : 'application/json'
			}
		})
.constant('RESOURCE_DOMAIN_FRONTEND', 'http://whatshapp.local:8080/whatsHappFrontend/images/tmpFiles/');
