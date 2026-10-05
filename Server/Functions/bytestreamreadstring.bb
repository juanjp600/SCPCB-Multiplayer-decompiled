Function bytestreamreadstring$(arg0.bs)
    Local local0$
    Local local1%
    Local local2%
    Local local3%
    local1 = bytestreamreadchar(arg0)
    local2 = (arg0\Field2 - arg0\Field3)
    If (local1 > local2) Then
        local1 = local2
    EndIf
    For local3 = $01 To local1 Step $01
        local0 = (local0 + chr(bytestreamreadchar(arg0)))
    Next
    Return local0
    Return ""
End Function
