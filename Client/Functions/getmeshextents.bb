Function getmeshextents%(arg0%)
    Local local0%
    Local local1%
    Local local2%
    Local local3%
    Local local4%
    Local local5#
    Local local6#
    Local local7#
    Local local8#
    Local local9#
    Local local10#
    Local local11#
    Local local12#
    Local local13#
    local8 = INFINITY
    local9 = INFINITY
    local10 = INFINITY
    local11 = (- INFINITY)
    local12 = (- INFINITY)
    local13 = (- INFINITY)
    local2 = countsurfaces(arg0)
    For local0 = $01 To local2 Step $01
        local1 = getsurface(arg0, local0)
        local4 = countvertices(local1)
        For local3 = $00 To (local4 - $01) Step $01
            local5 = vertexx(local1, local3)
            local6 = vertexy(local1, local3)
            local7 = vertexz(local1, local3)
            If (local8 > local5) Then
                local8 = local5
            EndIf
            If (local11 < local5) Then
                local11 = local5
            EndIf
            If (local9 > local6) Then
                local9 = local6
            EndIf
            If (local12 < local6) Then
                local12 = local6
            EndIf
            If (local10 > local7) Then
                local10 = local7
            EndIf
            If (local13 < local7) Then
                local13 = local7
            EndIf
        Next
    Next
    mesh_minx = local8
    mesh_miny = local9
    mesh_minz = local10
    mesh_maxx = local11
    mesh_maxy = local12
    mesh_maxz = local13
    mesh_magx = (local11 - local8)
    mesh_magy = (local12 - local9)
    mesh_magz = (local13 - local10)
    Return $00
End Function
