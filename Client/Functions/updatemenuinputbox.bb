Function updatemenuinputbox$(arg0%, arg1%, arg2%, arg3%, arg4$, arg5%, arg6%, arg7%, arg8#)
    Local local0.menuinputbox
    Local local1.menuinputbox
    Local local2%
    Local local3%
    local2 = $00
    For local0 = Each menuinputbox
        If (((((local0\Field0 = arg0) And (local0\Field1 = arg1)) And (local0\Field2 = arg2)) And (local0\Field3 = arg3)) <> 0) Then
            local2 = $01
            Exit
        EndIf
    Next
    If (local2 = $00) Then
        local0 = (New menuinputbox)
        local0\Field0 = arg0
        local0\Field1 = arg1
        local0\Field2 = arg2
        local0\Field3 = arg3
        local0\Field4 = arg4
        local0\Field5 = arg5
        local0\Field6 = arg6
        local0\Field7 = arg8
    Else
        local1 = local0
        local1\Field4 = arg4
        local1\Field5 = arg5
        local1\Field7 = arg8
    EndIf
    local3 = $00
    If (mouseon(arg0, arg1, arg2, arg3) <> 0) Then
        local3 = $01
        If (mo\Field0 <> 0) Then
            selectedinputbox = arg6
            flushkeys()
            cursorpos = $FFFFFFFE
        EndIf
    EndIf
    If ((((local3 = $00) And mo\Field0) And (selectedinputbox = arg6)) <> 0) Then
        selectedinputbox = $00
        cursorpos = $FFFFFFFE
    EndIf
    If (selectedinputbox = arg6) Then
        arg4 = updateinput(arg4, arg7)
    EndIf
    Return arg4
    Return ""
End Function
