Function updatemenubutton%(arg0%, arg1%, arg2%, arg3%, arg4$, arg5%, arg6%, arg7%, arg8%, arg9%, arg10%, arg11%, arg12#, arg13%, arg14%)
    Local local0.menubutton
    Local local1.menubutton
    Local local2%
    Local local3%
    local2 = $00
    local3 = $00
    For local0 = Each menubutton
        If (((((local0\Field0 = arg0) And (local0\Field1 = arg1)) And (local0\Field2 = arg2)) And (local0\Field3 = arg3)) <> 0) Then
            local3 = $01
            Exit
        EndIf
    Next
    If (local3 = $00) Then
        local0 = (New menubutton)
        local0\Field0 = arg0
        local0\Field1 = arg1
        local0\Field2 = arg2
        local0\Field3 = arg3
        local0\Field4 = arg4
        local0\Field5 = arg5
        local0\Field6 = arg7
        local0\Field8 = arg8
        local0\Field10 = arg10
        local0\Field9 = arg9
        local0\Field11 = arg12
        local0\Field7 = arg13
        local0\Field12 = arg14
    Else
        local1 = local0
        local1\Field4 = arg4
        local1\Field5 = arg5
        local1\Field6 = arg7
        local1\Field11 = arg12
        local1\Field7 = arg13
        local1\Field12 = arg14
    EndIf
    If (arg14 <> 0) Then
        Return $00
    EndIf
    If (mouseon(arg0, arg1, arg2, arg3) <> 0) Then
        If (((mo\Field0 And (arg6 = $00)) Lor ((mo\Field6 And arg6) And (onbuttonid = (((arg0 + arg1) + arg2) + arg3)))) <> 0) Then
            If (arg7 <> 0) Then
                If (arg11 <> 0) Then
                    playsound_strict(buttonsfx[$01], $00, $01)
                EndIf
            Else
                local2 = $01
                If (arg11 <> 0) Then
                    playsound_strict(buttonsfx[$00], $00, $01)
                EndIf
            EndIf
            If (arg6 <> 0) Then
                onbuttonid = $00
            EndIf
        EndIf
        If ((mo\Field0 And arg6) <> 0) Then
            onbuttonid = (((arg0 + arg1) + arg2) + arg3)
        EndIf
    EndIf
    Return local2
    Return $00
End Function
