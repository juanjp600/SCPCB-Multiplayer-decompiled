Function createsky%(arg0$, arg1%)
    Local local0%
    Local local1%
    Local local2$
    Local local3%
    Local local4%
    Local local5%
    Local local6%
    Local local7%
    Local local8%
    Local local9%
    Local local10$
    Local local11%
    Restore DATA_00000000
    local0 = createmesh(arg1)
    For local1 = $01 To $06 Step $01
        Read local2
        local10 = ((arg0 + local2) + ".png")
        If (filetype(local10) = $01) Then
            local11 = loadbrush_strict(local10, $31, 1.0, 1.0)
            local4 = createsurface(local0, local11)
            For local3 = $01 To $04 Step $01
                Read local5
                Read local6
                Read local7
                Read local8
                Read local9
                addvertex(local4, (Float local5), (Float local6), (Float local7), (Float local8), (Float local9), 1.0)
            Next
            addtriangle(local4, $00, $01, $02)
            addtriangle(local4, $00, $02, $03)
            freebrush(local11)
            local11 = $00
        EndIf
    Next
    flipmesh(local0)
    entityfx(local0, $09)
    entityorder(local0, $3E8)
    Return local0
    Return $00
End Function
