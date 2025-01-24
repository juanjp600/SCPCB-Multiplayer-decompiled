Function updatemenutick%(arg0%, arg1%, arg2%, arg3%)
    Local local0.menutick
    Local local1.menutick
    Local local2%
    Local local3%
    Local local4%
    Local local5%
    local2 = $00
    local3 = (Int (20.0 * menuscale))
    local4 = (Int (20.0 * menuscale))
    For local0 = Each menutick
        If (((local0\Field0 = arg0) And (local0\Field1 = arg1)) <> 0) Then
            local2 = $01
            Exit
        EndIf
    Next
    If (local2 = $00) Then
        local0 = (New menutick)
        local0\Field0 = arg0
        local0\Field1 = arg1
        local0\Field2 = arg2
        local0\Field3 = arg3
    Else
        local1 = local0
        local1\Field2 = arg2
        local1\Field3 = arg3
    EndIf
    local5 = mouseon(arg0, arg1, local3, local4)
    If (local5 <> 0) Then
        If (mo\Field0 <> 0) Then
            If (arg3 <> 0) Then
                playsound_strict(buttonsfx[$01], $00)
            Else
                arg2 = (arg2 = $00)
                playsound_strict(buttonsfx[$00], $00)
            EndIf
        EndIf
    EndIf
    Return arg2
    Return $00
End Function
