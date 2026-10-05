Function se_bl_array_create%()
    Local local0.se_array
    Local local1%
    Local local2%
    local0 = se_array_create()
    local1 = (Int min(max((Float se_tointarg($00, $00)), 0.0), 65536.0))
    For local2 = $01 To local1 Step $01
        se_array_addelement(local0)
    Next
    se_returnarray(local0)
    Return $00
End Function
