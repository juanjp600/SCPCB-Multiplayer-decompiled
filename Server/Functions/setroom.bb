Function setroom%(arg0$, arg1%, arg2%, arg3%, arg4%)
    Local local0%
    Local local1%
    If (arg4 < arg3) Then
        Return $00
    EndIf
    local0 = $00
    local1 = $01
    While (maproom(arg1, arg2) <> "")
        arg2 = (arg2 + $01)
        If (arg2 > arg4) Then
            If (local0 = $00) Then
                arg2 = (arg3 + $01)
                local0 = $01
            Else
                local1 = $00
                Exit
            EndIf
        EndIf
    Wend
    If (local1 = $01) Then
        maproom(arg1, arg2) = arg0
        Return $01
    Else
        Return $00
    EndIf
    Return $00
End Function
