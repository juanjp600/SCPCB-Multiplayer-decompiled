Function voice_attachecho%(arg0%)
    If (echo_effect <> $00) Then
        alsourceattacheffect(arg0, echo_effect, $00)
        Return $01
    EndIf
    Return $00
    Return $00
End Function
