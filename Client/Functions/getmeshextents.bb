Function getmeshextents%(arg0%)
    Local local0%
    Local local1%
    Local local2%
    Local local3#
    Local local4#
    Local local5#
    Local local6#
    Local local7#
    Local local8#
    Local local9#
    Local local10#
    Local local11#
    Local local12%
    Local local13%
    local6 = INFINITY
    local7 = INFINITY
    local8 = INFINITY
    local9 = (- INFINITY)
    local10 = (- INFINITY)
    local11 = (- INFINITY)
    local12 = countsurfaces(arg0)
    For local0 = $01 To local12 Step $01
        local1 = getsurface(arg0, local0)
        local13 = (countvertices(local1) - $01)
        For local2 = $00 To local13 Step $01
            local3 = vertexx(local1, local2)
            local4 = vertexy(local1, local2)
            local5 = vertexz(local1, local2)
            local6 = min(local6, local3)
            local9 = max(local9, local3)
            local7 = min(local7, local4)
            local10 = max(local10, local4)
            local8 = min(local8, local5)
            local11 = max(local11, local5)
        Next
    Next
    mesh_minx = local6
    mesh_miny = local7
    mesh_minz = local8
    mesh_maxx = local9
    mesh_maxy = local10
    mesh_maxz = local11
    mesh_magx = (local9 - local6)
    mesh_magy = (local10 - local7)
    mesh_magz = (local11 - local8)
    Return $00
End Function
