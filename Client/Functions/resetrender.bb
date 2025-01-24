Function resetrender%()
    Local local0.items
    Local local1.npcs
    updatelightstimer = 0.0
    updatelightvolume()
    updatelights(camera)
    updatedoors()
    updatedecals()
    updaterooms()
    For local0 = Each items
        local0\Field11 = 0.0
        local0\Field5 = 0.0
    Next
    For local1 = Each npcs
        local1\Field16 = 0.0
        local1\Field7 = 0.0
    Next
    me\Field36 = 0.0
    shouldentitiesfall = $00
    Return $00
End Function
