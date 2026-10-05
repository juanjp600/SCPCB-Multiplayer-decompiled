Function createpropobj.props(arg0$, arg1$)
    Local local0.props
    Local local1.props
    For local0 = Each props
        If (local0\Field0 = arg0) Then
            If (local0\Field1 <> $00) Then
                local1 = (New props)
                local1\Field0 = arg0
                local1\Field1 = copyentity(local0\Field1, $00)
                hideentity(local1\Field1)
                Return local1
            Else
                Exit
            EndIf
        EndIf
    Next
    local0 = (New props)
    local0\Field0 = arg0
    local0\Field1 = loadmesh(arg0, $00)
    If (local0\Field1 = $00) Then
        createconsolemsg(((("FILE MISSING: " + arg0) + " Room: ") + arg1), $FF, $FF, $00, $00)
        local0\Field1 = copyentity(g_model\Field0, $00)
        hideentity(local0\Field1)
    Else
        applyreflection(local0\Field1)
        hideentity(local0\Field1)
    EndIf
    Return local0
    Return Null
End Function
