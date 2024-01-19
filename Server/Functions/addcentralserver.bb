Function addcentralserver%(arg0$, arg1%)
    Local local0.centralserversegments
    For local0 = Each centralserversegments
        If (((local0\Field0 = arg0) And (local0\Field1 = arg1)) <> 0) Then
            Return $00
        EndIf
    Next
    local0 = (New centralserversegments)
    local0\Field0 = arg0
    local0\Field1 = arg1
    counthostips(arg0)
    local0\Field2 = hostip($01)
    Return $00
End Function
