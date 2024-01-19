Function opus_pcm_decode%(arg0%, arg1%, arg2%)
    Local local0%
    If (arg0 = $00) Then
        Return $00
    EndIf
    local0 = createbank((opus_get_default_frame_size() Shl $01))
    opus_decode(arg0, arg1, banksize(arg1), local0, opus_get_default_frame_size(), arg2)
    Return local0
    Return $00
End Function
