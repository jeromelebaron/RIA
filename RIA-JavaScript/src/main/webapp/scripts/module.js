var module = (function () {
	
	function methodePublic () {
		alert('message');
		methodePrivee();
	}

	function methodePrivee () {
		console.log('Privée');
	}

	return {
		methodePublic : methodePublic,
		attributExpose : 'coucou'
	};

})();