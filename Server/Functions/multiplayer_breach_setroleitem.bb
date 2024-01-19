Function multiplayer_breach_setroleitem%(arg0%, arg1$, arg2%)
    Local local0%
    Local local1%
    Local local2.breachtypes
    If (arg1 = "null") Then
        local0 = arg0
        If (local0 = model_860) Then
            local1 = arg2
            If (local1 = $00) Then
                arg1 = "Level 3 Key Card/key3"
            EndIf
        EndIf
    EndIf
    local2 = getbreachtype(arg0)
    local2\Field56[arg2] = arg1
    Return $00
End Function
