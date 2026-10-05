Function se_deletescript%(arg0.se_script)
    Local local0%
    Local local1.se_inst
    Local local2.se_funcptr
    Local local3.se_public
    Local local4.se_funcptr
    Local local5.se_public
    Local local6.se_inst
    Local local7.se_pendingdelete
    If (arg0 = Null) Then
        Return $00
    EndIf
    removetimersforscript(arg0)
    se_delete_generation = (se_delete_generation + $01)
    local0 = se_delete_generation
    local1 = arg0\Field0
    local2 = arg0\Field2
    local3 = arg0\Field5
    While (local2 <> Null)
        local4 = local2\Field7
        Delete local2
        local2 = local4
    Wend
    While (local3 <> Null)
        local5 = local3\Field3
        se_markdeletevalue(local3\Field1, local0)
        Delete local3
        local3 = local5
    Wend
    While (local1 <> Null)
        local6 = local1\Field5
        se_markdeletevalue(local1\Field1, local0)
        se_markdeletevalue(local1\Field2, local0)
        se_markdeletevalue(local1\Field3, local0)
        Delete local1
        local1 = local6
    Wend
    For local7 = Each se_pendingdelete
        se_gccheck(local7\Field0)
        Delete local7\Field0
        Delete local7
    Next
    Delete arg0
    Return $00
End Function
