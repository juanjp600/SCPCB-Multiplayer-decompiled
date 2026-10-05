Function se_markdeletevalue%(arg0.se_value, arg1%)
    Local local0.se_pendingdelete
    If (arg0 = Null) Then
        Return $00
    EndIf
    If (arg0\Field1 = arg1) Then
        Return $00
    EndIf
    arg0\Field1 = arg1
    local0 = (New se_pendingdelete)
    local0\Field0 = arg0
    Return $00
End Function
