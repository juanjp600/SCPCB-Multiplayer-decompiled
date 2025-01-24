Function blitz_mp_readline0$(arg0.mp_netbuffer)
    Local local0%
    local0 = (peekint(arg0\Field0, arg0\Field1) And $7FFFFFFF)
    If ((arg0\Field1 + local0) > arg0\Field2) Then
        Return ""
    EndIf
    arg0\Field1 = ((arg0\Field1 + local0) + $04)
    Return peekstring(arg0\Field0, ((arg0\Field1 - local0) - $04))
    Return ""
End Function
