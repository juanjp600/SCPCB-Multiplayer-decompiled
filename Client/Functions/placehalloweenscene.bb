Function placehalloweenscene%(arg0.rooms, arg1%, arg2%, arg3#, arg4#, arg5#, arg6#)
    Local local0%
    Local local1%
    Local local2%
    Local local3%
    Local local4%
    If (halloweenindex <> 0) Then
        local0 = copyentity(halloweenscene[arg2], $00)
        positionentity(local0, arg3, (arg4 + 1.0), arg5, $00)
        rotateentity(local0, 90.0, arg6, 0.0, $00)
        entitytype(local0, $01, $00)
        entityfx(local0, $10)
        If (entitypick(local0, 10000.0) <> 0) Then
            positionentity(local0, arg3, pickedy(), arg5, $00)
        EndIf
        rotateentity(local0, 0.0, arg6, 0.0, $00)
        local1 = findchild(local0, "Cylinder.007")
        If (local1 <> $00) Then
            local2 = addlight(arg0, entityx(local1, $01), entityy(local1, $01), entityz(local1, $01), $02, 0.2, $F2, $9D, $00)
            entityparent(local2, local1, $01)
            For local3 = $00 To arg0\Field18 Step $01
                If (arg0\Field16[local3] = local2) Then
                    entityparent(arg0\Field20[local3], local1, $01)
                    entityparent(arg0\Field24[local3], local1, $01)
                    moveentity(arg0\Field21[local3], 0.0, 1410065000.0, 0.0)
                EndIf
            Next
        Else
            addlight(arg0, arg3, arg4, arg5, $04, 0.2, $F2, $9D, $00)
        EndIf
        entityparent(local0, arg0\Field2, $01)
        scaleentity(local0, ((0.7 + (Float local4)) * 80.0), ((0.7 + (Float local4)) * 80.0), ((0.7 + (Float local4)) * 80.0), $00)
        addentitytoroomprops(arg0, local0)
    ElseIf (newyearindex <> 0) Then
        local0 = copyentity(halloweenscene[arg2], $00)
        positionentity(local0, arg3, (arg4 + 1.0), arg5, $00)
        rotateentity(local0, 90.0, wrapangle((arg6 + 90.0)), 0.0, $00)
        entitytype(local0, $01, $00)
        entityfx(local0, $10)
        If (entitypick(local0, 10000.0) <> 0) Then
            positionentity(local0, arg3, (pickedy() + 0.045), arg5, $00)
        EndIf
        rotateentity(local0, 0.0, wrapangle((arg6 + 90.0)), 0.0, $00)
        scaleentity(local0, 0.004, 0.004, 0.004, $00)
        addentitytoroomprops(arg0, local0)
    EndIf
    Return $00
End Function
