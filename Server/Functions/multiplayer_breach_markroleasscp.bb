Function multiplayer_breach_markroleasscp%(arg0%, arg1%)
    Local local0.breachtypes
    local0 = getbreachtype(arg0)
    local0\Field9 = arg1
    If (((arg1 = $01) And local0\Field54) <> 0) Then
        local0\Field9 = $00
    EndIf
    Return $00
End Function
