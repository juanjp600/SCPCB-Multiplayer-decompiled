Function rowtext%(arg0$, arg1%, arg2%, arg3%, arg4%, arg5%, arg6#)
    Local local0%
    Local local1%
    Local local2$
    Local local3%
    Local local4$
    Local local5$
    Local local6%
    If (arg4 < $01) Then
        arg4 = (Int smallest_power_two)
    EndIf
    local0 = $00
    local1 = (Int ((Float stringheight(arg0)) + arg6))
    While (len(arg0) > $00)
        local3 = instr(arg0, splitspace, $01)
        If (local3 = $00) Then
            local3 = len(arg0)
        EndIf
        local4 = left(arg0, local3)
        local5 = trim(local4)
        local6 = $00
        If (((stringwidth((local2 + local4)) > arg3) And (stringwidth((local2 + local5)) <= arg3)) <> 0) Then
            local4 = local5
            local6 = $01
        EndIf
        If (stringwidth((local2 + local4)) > arg3) Then
            If (arg5 <> 0) Then
                textex((((arg3 Sar $01) + arg1) - (stringwidth(local2) Sar $01)), ((local0 * local1) + arg2), local2, $00, $00)
            Else
                textex(arg1, ((local0 * local1) + arg2), local2, $00, $00)
            EndIf
            local0 = (local0 + $01)
            local2 = ""
        Else
            local2 = (local2 + local4)
            arg0 = right(arg0, (len(arg0) - (len(local4) + local6)))
        EndIf
        If (((local0 + $01) * local1) > arg4) Then
            Exit
        EndIf
    Wend
    If (((local2 <> "") And ((local0 + $01) <= arg4)) <> 0) Then
        If (arg5 <> 0) Then
            textex((((arg3 Sar $01) + arg1) - (stringwidth(local2) Sar $01)), ((local0 * local1) + arg2), local2, $00, $00)
        Else
            textex(arg1, ((local0 * local1) + arg2), local2, $00, $00)
        EndIf
    EndIf
    Return $00
End Function
