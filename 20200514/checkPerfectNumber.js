var checkPerfectNumber = function(num) {
	let sum=0;
	if (!num) return false;
	for (let i=1; i<num; i++){
		if (num%i===0){
			sum+=i
		}
	}
	return sum===num
};
