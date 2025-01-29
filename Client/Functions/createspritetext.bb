Function createspritetext%(arg0.spritefont, arg1$, arg2%, arg3%)
    Local local0%
    Local local1%
    Local local2%
    Local local3%
    Local local4#
    Local local5#
    Local local6$
    Local local7%
    Local local8%
    Local local9%
    Local local10#
    Local local11%
    If (arg0 = Null) Then
        Return $00
    EndIf
    local0 = createsprite($00)
    local1 = len(arg1)
    If (arg0 <> Null) Then
        setfont(arg0\Field1)
        local3 = createtexture($400, (Int arg0\Field3), $135, $01)
        If (local3 <> $00) Then
            maskbuffer(texturebuffer(local3, $00), texturewidth(local3), textureheight(local3))
            setbuffer(texturebuffer(local3, $00))
            local4 = (Float stringwidth(arg1))
            For local2 = $01 To local1 Step $01
                local6 = mid(arg1, local2, $01)
                local10 = ((Float local2) / (Float local1))
                local7 = (Int (((Float readpixelcolor(arg2, $10)) * (1.0 - local10)) + ((Float readpixelcolor(arg3, $10)) * local10)))
                local8 = (Int (((Float readpixelcolor(arg2, $08)) * (1.0 - local10)) + ((Float readpixelcolor(arg3, $08)) * local10)))
                local9 = (Int (((Float readpixelcolor(arg2, $00)) * (1.0 - local10)) + ((Float readpixelcolor(arg3, $00)) * local10)))
                local11 = (Int ((local5 + 512.0) - (local4 / 2.0)))
                color((Int max((Float (local7 - $32)), 0.0)), (Int max((Float (local8 - $32)), 0.0)), (Int max((Float (local9 - $32)), 0.0)))
                text((local11 - $01), $00, local6, $00, $00)
                text((local11 + $01), $00, local6, $00, $00)
                color(local7, local8, local9)
                text(local11, $00, local6, $00, $00)
                local5 = ((arg0\Field2 * (Float stringwidth(local6))) + local5)
            Next
            setbuffer(backbuffer())
            positiontexture(local3, 0.0, 0.01)
            entitytexture(local0, local3, $00, $00)
            freetexture(local3)
        EndIf
    EndIf
    Return local0
    Return $00
End Function
