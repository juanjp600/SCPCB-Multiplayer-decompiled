Function updatemenutextbox%(arg0%, arg1%, arg2%, arg3%, arg4$, arg5%, arg6#)
    Local local0.menutextbox
    Local local1.menutextbox
    Local local2%
    local2 = $00
    For local0 = Each menutextbox
        If (((((local0\Field0 = arg0) And (local0\Field1 = arg1)) And (local0\Field2 = arg2)) And (local0\Field3 = arg3)) <> 0) Then
            local2 = $01
            Exit
        EndIf
    Next
    If (local2 = $00) Then
        local0 = (New menutextbox)
        local0\Field0 = arg0
        local0\Field1 = arg1
        local0\Field2 = arg2
        local0\Field3 = arg3
        local0\Field4 = arg4
        local0\Field6 = arg6
        local0\Field5 = arg5
    Else
        local1 = local0
        local1\Field4 = arg4
        local1\Field6 = arg6
        local1\Field5 = arg5
    EndIf
    Return $00
End Function
