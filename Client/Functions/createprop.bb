Function createprop.props(arg0.rooms, arg1$, arg2#, arg3#, arg4#, arg5#, arg6#, arg7#, arg8#, arg9#, arg10#, arg11%, arg12%, arg13$)
    Local local0.props
    Local local1.props
    local0 = (New props)
    For local1 = Each props
        If (local1\Field0 = arg1) Then
            local0\Field1 = copyentity(local1\Field1, $00)
            Exit
        EndIf
    Next
    local0\Field0 = arg1
    local0\Field2 = arg0
    local0\Field3 = arg13
    local0\Field4 = (arg1 = "GFX\Map\Props\water_cooler.b3d")
    If (local0\Field1 = $00) Then
        local0\Field1 = loadmesh_strict(arg1, $00)
    EndIf
    positionentity(local0\Field1, arg2, arg3, arg4, $00)
    rotateentity(local0\Field1, arg5, arg6, arg7, $00)
    If (arg0 <> Null) Then
        entityparent(local0\Field1, arg0\Field2, $01)
    EndIf
    scaleentity(local0\Field1, arg8, arg9, arg10, $00)
    entitytype(local0\Field1, arg11, $00)
    entityfx(local0\Field1, arg12)
    entitypickmode(local0\Field1, $02, $01)
    Return local0
    Return Null
End Function
