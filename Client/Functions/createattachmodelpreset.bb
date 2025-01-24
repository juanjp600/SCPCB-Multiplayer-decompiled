Function createattachmodelpreset.mp_attachmodelpreset(arg0%, arg1%)
    Local local0.mp_attachmodel
    local0 = findattachmodel(arg0)
    If (local0 = Null) Then
        Return Null
    EndIf
    If (local0\Field9[arg1] = Null) Then
        local0\Field9[arg1] = (New mp_attachmodelpreset)
    EndIf
    Return local0\Field9[arg1]
    Return Null
End Function
