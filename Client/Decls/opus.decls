.lib "opus.dll"

opus_encoder_create%(param0%, param1%, param2%, param3%):"_opus_encoder_create@16"
opus_encode%(param0%, param1*, param2%, param3*, param4%):"_opus_encode@20"
opus_encoder_destroy%(param0%):"_opus_encoder_destroy@4"
opus_decoder_create%(param0%, param1%, param2%):"_opus_decoder_create@12"
opus_decode%(param0%, param1*, param2%, param3*, param4%, param5%):"_opus_decode@24"
opus_decoder_destroy%(param0%):"_opus_decoder_destroy@4"
opus_encoder_set_ctl%(param0%, param1%, param2%):"opus_encoder_ctl"
