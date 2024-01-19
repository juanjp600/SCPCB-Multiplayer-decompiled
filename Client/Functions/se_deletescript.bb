Function se_deletescript%(arg0.se_script)
    Local local0.se_inst
    Local local1.se_funcptr
    Local local2.se_public
    Local local3.se_funcptr
    Local local4.se_public
    Local local5.se_inst
    local0 = arg0\Field0
    local1 = arg0\Field2
    local2 = arg0\Field5
    While (local1 <> Null)
        local3 = local1\Field7
        Delete local1
        local1 = local3
    Wend
    While (local2 <> Null)
        local4 = local2\Field3
        Delete local2
        local2 = local4
    Wend
    While (local0 <> Null)
        local5 = local0\Field5
        If (local0\Field1 <> Null) Then
            se_gccheck(local0\Field1)
            Delete local0\Field1
        EndIf
        If (local0\Field2 <> Null) Then
            se_gccheck(local0\Field2)
            Delete local0\Field2
        EndIf
        If (local0\Field3 <> Null) Then
            se_gccheck(local0\Field3)
            Delete local0\Field3
        EndIf
        local0 = local5
    Wend
    Delete arg0
    Return $00
End Function
