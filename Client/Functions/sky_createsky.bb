Function sky_createsky%(arg0$, arg1%)
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
    Restore DATA_00001AF8
    local0 = createmesh(arg1)
    For local1 = $01 To $06 Step $01
        Read local2
        local3 = ((arg0 + local2) + ".jpg")
        If (filetype(local3) = $01) Then
            local4 = loadbrush_strict(local3, $31, 1.0, 1.0)
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
    entityorder(local0, $3E8)
    Return local0
    Return $00
End Function
