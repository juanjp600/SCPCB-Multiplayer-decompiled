Function mp_reloadvoicedevice%()
    Local local0%
    Local local1%
    Local local2%
    If (mp_voice = Null) Then
        Return $00
    EndIf
    bass_recordfree()
    local0 = bass_getrecorddevicecount()
    If (local0 = $00) Then
        mp_removevoice()
        Return $00
    EndIf
    local1 = $FFFFFFFF
    If (opt\Field48 <> "") Then
        For local2 = $00 To (local0 - $01) Step $01
            If (bass_getrecorddevicename(local2) = opt\Field48) Then
                local1 = bass_getrecorddevice(local2)
                Exit
            EndIf
        Next
    EndIf
    If (bass_recordinit(local1) = $00) Then
        mp_removevoice()
        Return $00
    EndIf
    mp_voice\Field1 = bass_recordstart(opus_get_sample_rate(), opus_get_channels(), $00, $00, $00)
    Return $00
End Function
