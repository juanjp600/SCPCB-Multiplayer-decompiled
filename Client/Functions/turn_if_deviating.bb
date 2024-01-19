Function turn_if_deviating%(arg0%, arg1%, arg2%, arg3%, arg4%)
    Local local0%
    Local local1%
    local0 = (arg2 - arg1)
    local1 = $00
    If ((((arg3 = $00) And (local0 >= arg0)) Or ((arg3 = $02) And (local0 <= (- arg0)))) <> 0) Then
        arg3 = ((arg3 + $02) Mod $04)
        local1 = $01
    EndIf
    If (arg4 = $00) Then
        Return arg3
    Else
        Return local1
    EndIf
    Return $00
End Function
