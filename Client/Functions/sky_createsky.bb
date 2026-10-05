Function sky_createsky%(arg0%, arg1%, arg2$)
    Local local0%
    Local local1%
    Local local2$
    Local local3$
    Local local4%
    Local local5%
    Local local6%
    Local local7%
    Local local8%
    Local local9%
    Local local10%
    Local local11%
    Local local12#
    Local local13#
    Local local14#
    Local local15#
    Local local16#
    Local local17#
    Local local18#
    Local local19#
    Local local20#
    Local local21#
    Local local22#
    If (sky[arg1] <> $00) Then
        freeentity(sky[arg1])
    EndIf
    local0 = createmesh($00)
    Restore DATA_00001B50
    For local1 = $01 To $06 Step $01
        Read local2
        local3 = ((arg2 + local2) + ".jpg")
        If (filetype(local3) = $01) Then
            local4 = loadbrush_strict(local3, $131, 1.0, 1.0)
            local5 = createsurface(local0, local4)
            For local6 = $01 To $04 Step $01
                Read local7
                Read local8
                Read local9
                Read local10
                Read local11
                addvertex(local5, (Float local7), (Float local8), (Float local9), (Float local10), (Float local11), 1.0)
            Next
            addtriangle(local5, $00, $01, $02)
            addtriangle(local5, $00, $02, $03)
            freebrush(local4)
        EndIf
    Next
    flipmesh(local0)
    entityfx(local0, $09)
    If (arg0 <> $FFFFFFFF) Then
        local12 = meshwidth(arg0)
        local13 = meshheight(arg0)
        local14 = meshdepth(arg0)
        local15 = 2.0
        local16 = ((local12 / local15) * 3.0)
        local17 = ((local13 / local15) * 3.0)
        local18 = ((local14 / local15) * 3.0)
        positionentity(local0, entityx(arg0, $01), entityy(arg0, $01), entityz(arg0, $01), $01)
        scaleentity(local0, local16, local17, local18, $00)
        local19 = (local12 * 0.5)
        local20 = (local13 * 0.5)
        local21 = (local14 * 0.5)
        local22 = sqr((((local19 * local19) + (local20 * local20)) + (local21 * local21)))
        sky_planedist[arg1] = (local22 * 3.5)
        sky_fogdist[arg1] = (local22 * 0.75)
    EndIf
    sky[arg1] = local0
    Return $00
End Function
