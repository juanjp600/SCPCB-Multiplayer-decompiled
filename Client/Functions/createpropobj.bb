Function createpropobj.props(arg0$)
    Local local0.props
    Local local1.props
    For local0 = Each props
        If (local0\Field0 = arg0) Then
            local1 = (New props)
            local1\Field0 = arg0
            local1\Field1 = copyentity(local0\Field1, $00)
            hideentity(local1\Field1)
            Return local1
        EndIf
    Next
    local0 = (New props)
    local0\Field0 = arg0
    local0\Field1 = loadmesh(arg0, $00)
    hideentity(local0\Field1)
    Return local0
    Return Null
End Function
