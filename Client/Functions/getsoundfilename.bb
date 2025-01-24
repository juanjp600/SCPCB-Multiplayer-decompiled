Function getsoundfilename$(arg0%)
    Local local0.sound
    local0 = (Object.sound arg0)
    If (local0 <> Null) Then
        Return local0\Field1
    EndIf
    Return ""
    Return ""
End Function
