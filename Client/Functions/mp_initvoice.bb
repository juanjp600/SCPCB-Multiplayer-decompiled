Function mp_initvoice%(arg0%, arg1%, arg2%, arg3%)
    Local local0%
    Local local1%
    Local local2%
    Local local3%
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
    opus_encoder_ctl_bb(getopusencoder(), $FA2, arg2)
    local0 = $00
    opus_encoder_ctl_bb(getopusencoder(), $FA3, local0)
    local1 = bass_getrecorddevicecount()
    If (local1 = $00) Then
        Return $00
    EndIf
    local2 = $FFFFFFFF
    If (opt\Field48 <> "") Then
        For local3 = $00 To (local1 - $01) Step $01
            If (bass_getrecorddevicename(local3) = opt\Field48) Then
                local2 = bass_getrecorddevice(local3)
                Exit
            EndIf
        Next
    EndIf
    If (bass_recordinit(local2) = $00) Then
        Return $00
    EndIf
    mp_voice = (New mp_voicesystem)
    mp_voice\Field1 = bass_recordstart(opus_get_sample_rate(), opus_get_channels(), $00, $00, $00)
    mp_voice\Field2 = createbank((opus_get_default_frame_size() Shl $01))
    mp_voice\Field3 = createbank($00)
    Return $00
End Function
