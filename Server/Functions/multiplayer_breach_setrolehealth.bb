Function multiplayer_breach_setrolehealth%(arg0%, arg1%)
    Local local0.breachtypes
    If (arg1 <> $FFFFFFFF) Then
        local0 = getbreachtype(arg0)
        local0\Field8 = arg1
    EndIf
    Return $00
End Function
