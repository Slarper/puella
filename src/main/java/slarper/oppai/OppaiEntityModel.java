package slarper.oppai;

import net.minecraft.client.model.*;
import net.minecraft.util.math.Direction;
import slarper.customuv.CustomUv;

public class OppaiEntityModel {

    public static final int TEXTURE_U_SIZE = 64;
    public static final int TEXTURE_V_SIZE = 64;


    public static TexturedModelData getTexturedModelData(){
        ModelData modelData = new ModelData();
        ModelPartData root = modelData.getRoot();
        root.addChild(
                "oppai",
                ModelPartBuilder.create()
                        .uv(15,21)
                        .cuboid(-4F, -2F,-2.5F, 8,4,5, new Dilation(-0.1F)),
                ModelTransform.of(
                        0.0F,4F,-2F,
                        0.872665F, 0F, 0F
                )
        );
        root.addChild(
                "bra",
                ModelPartBuilder.create()
                        .uv(15,37)
                        .cuboid(-4F, -2F,-2.5F, 8,4,5, new Dilation(0.25F)),
                ModelTransform.of(
                        0.0F,4F,-2F,
                        0.872665F, 0F, 0F
                )
        );
        return TexturedModelData.of(modelData, 64, 64);
    }

    public static ModelPart getModel(){
        ModelPart model = getTexturedModelData().createModel();
        ModelPart oppai = model.getChild("oppai");
        CustomUv.setUv(20, 25, 28, 29, TEXTURE_U_SIZE, TEXTURE_V_SIZE,
                CustomUv.getFace(oppai,0, Direction.NORTH),
                0, 1, 2, 3
                );
        CustomUv.setUv(28 - 1,21,32 - 1,26,TEXTURE_U_SIZE,TEXTURE_V_SIZE,
                CustomUv.getFace(oppai, 0, Direction.EAST),
                3,0,1,2
                );
        CustomUv.setUv(16 + 1,21,20 + 1,26,TEXTURE_U_SIZE,TEXTURE_V_SIZE,
                CustomUv.getFace(oppai, 0, Direction.WEST),
                1,2,3,0
        );
        ModelPart bra = model.getChild("bra");
        CustomUv.setUv(20, 25 + 16, 28, 29 + 16, TEXTURE_U_SIZE, TEXTURE_V_SIZE,
                CustomUv.getFace(bra,0, Direction.NORTH),
                0, 1, 2, 3
        );
        CustomUv.setUv(28 - 1,21 + 16,32 - 1,26 + 16,TEXTURE_U_SIZE,TEXTURE_V_SIZE,
                CustomUv.getFace(bra, 0, Direction.EAST),
                3,0,1,2
        );
        CustomUv.setUv(16 + 1,21 + 16,20 + 1,26 + 16,TEXTURE_U_SIZE,TEXTURE_V_SIZE,
                CustomUv.getFace(bra, 0, Direction.WEST),
                1,2,3,0
        );

        return model;
    }
}
