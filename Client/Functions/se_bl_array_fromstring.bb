Function se_bl_array_fromstring%()
    Local local0.se_array
    Local local1$
    Local local2%
    Local local3%
    Local local4.se_value
    local1 = se_tostringarg($00, "")
    local2 = len(local1)
    If (local2 = $00) Then
        Return $00
    EndIf
    local0 = se_array_create()
    For local3 = $01 To local2 Step $01
        local4 = se_array_addelement(local0)
        local4\Field0 = $03
        local4\Field3 = mid(local1, local3, $01)
    Next
    se_returnarray(local0)
    Return $00
End Function
