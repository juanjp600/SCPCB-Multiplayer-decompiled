Function updatemenuslider3%(arg0%, arg1%, arg2%, arg3%, arg4%, arg5$, arg6$, arg7$)
    Local local0.menuslider
    Local local1.menuslider
    Local local2%
    Local local3%
    local2 = $00
    local3 = (arg2 Sar $01)
    For local0 = Each menuslider
        If (((((local0\Field0 = arg0) And (local0\Field1 = arg1)) And (local0\Field2 = arg2)) And (local0\Field10 = $03)) <> 0) Then
            local2 = $01
            Exit
        EndIf
    Next
    If (local2 = $00) Then
        local0 = (New menuslider)
        local0\Field0 = arg0
        local0\Field1 = arg1
        local0\Field2 = arg2
        local0\Field4 = arg4
        local0\Field3 = arg3
        local0\Field5 = arg5
        local0\Field6 = arg6
        local0\Field7 = arg7
        local0\Field10 = $03
    Else
        local1 = local0
        local1\Field3 = arg3
    EndIf
    If ((mo\Field2 And (onsliderid = $00)) <> 0) Then
        If (mouseon(arg0, (Int ((Float arg1) - (8.0 * menuscale))), (Int ((14.0 * menuscale) + (Float arg2))), (Int (18.0 * menuscale))) <> 0) Then
            onsliderid = arg4
        EndIf
    EndIf
    If (arg4 = onsliderid) Then
        If (mouseposx <= ((8.0 * menuscale) + (Float arg0))) Then
            arg3 = $00
        ElseIf ((((Float (arg0 + local3)) <= mouseposx) And (mouseposx <= ((8.0 * menuscale) + (Float (arg0 + local3))))) <> 0) Then
            arg3 = $01
        ElseIf ((Float (arg0 + arg2)) <= mouseposx) Then
            arg3 = $02
        EndIf
    EndIf
    Return arg3
    Return $00
End Function
