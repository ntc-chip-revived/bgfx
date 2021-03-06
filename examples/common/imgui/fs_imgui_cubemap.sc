$input v_normal

/*
 * Copyright 2011-2013 Branimir Karadzic. All rights reserved.
 * License: http://www.opensource.org/licenses/BSD-2-Clause
 */

#include <bgfx_shader.sh>

uniform vec4 u_imageLodEnabled;
SAMPLERCUBE(s_texColor, 0);

#define u_imageLod     u_imageLodEnabled.x
#define u_imageEnabled u_imageLodEnabled.y

void main()
{
	vec3 color = textureCubeLod(s_texColor, v_normal, u_imageLod).xyz;
	float alpha = 0.2 + 0.8*u_imageEnabled;
	gl_FragColor = vec4(color, alpha);
}
