Function mp_initvoice%(arg0%, arg1%, arg2%, arg3%)
    If (mp_voice <> Null) Then
        Return $00
    EndIf
    opus_set_type(arg3)
    opus_set_channels($01)
    opus_set_sample_rate(arg1)
    opus_set_default_frame_size((Int ((Float opus_get_sample_rate()) * 0.06)))
    If (opus_get_new_encoder() = $00) Then
        Return $00
    EndIf
    senddebuglog(("Bitrate: " + (Str arg2)))
    opus_encoder_set_ctl(opus_get_current_encoder(), $FA2, arg2)
    If (bass_recordinit($FFFFFFFF) = $00) Then
        Return $00
    EndIf
    mp_voice = (New mp_voicesystem)
    mp_voice\Field1 = bass_recordstart(opus_get_sample_rate(), opus_get_channels(), $00, $00, $00)
    mp_voice\Field2 = createbank((opus_get_default_frame_size() Shl $01))
    mp_voice\Field3 = createbank($00)
    Return $00
End Function
