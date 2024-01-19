Function placehalloweenscene%(arg0.rooms, arg1%, arg2%, arg3#, arg4#, arg5#, arg6#)
    Local local0%
    Local local1%
    Local local2%
    Local local3%
    If (halloweenindex <> 0) Then
        local0 = createpivot($00)
        positionentity(local0, arg3, (arg4 + 1.0), arg5, $00)
        local1 = addlight(arg0, entityx(local0, $01), entityy(local0, $01), entityz(local0, $01), $02, 0.2, $F2, $9D, $00)
        entityparent(local1, local0, $01)
        moveentity(local1, 0.0, 1.5, 0.0)
        For local2 = $00 To arg0\Field18 Step $01
            If (arg0\Field16[local2] = local1) Then
                entityparent(arg0\Field20[local2], local0, $01)
                moveentity(arg0\Field20[local2], 0.0, 1.5, 0.0)
                entityparent(arg0\Field24[local2], local0, $01)
                moveentity(arg0\Field24[local2], 0.0, 1.5, 0.0)
            EndIf
        Next
        entityparent(local0, arg0\Field2, $01)
        scaleentity(local0, (0.7 + (Float local3)), (0.7 + (Float local3)), (0.7 + (Float local3)), $00)
    EndIf
    Return $00
End Function
