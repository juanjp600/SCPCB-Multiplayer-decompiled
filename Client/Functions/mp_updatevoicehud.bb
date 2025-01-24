Function mp_updatevoicehud%()
    Local local0#
    If (mp_voice = Null) Then
        Return $00
    EndIf
    local0 = 0.0
    If (mp_getvoicerecording() <> 0) Then
        local0 = (mp_voicegetlevel() * 100.0)
    EndIf
    mp_voice\Field5 = curvevalue(local0, mp_voice\Field5, 9.0)
    Return $00
    Return $00
End Function
