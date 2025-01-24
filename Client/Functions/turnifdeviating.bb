Function turnifdeviating%(arg0%, arg1%, arg2%, arg3%, arg4%)
    Local local0%
    Local local1%
    local0 = (arg2 - arg1)
    local1 = (((arg3 = $00) And (local0 >= arg0)) Lor ((arg3 = $02) And (local0 <= (- arg0))))
    If (local1 <> 0) Then
        arg3 = ((arg3 + $02) Mod $04)
    EndIf
    If (arg4 <> 0) Then
        Return local1
    Else
        Return arg3
    EndIf
    Return $00
End Function
